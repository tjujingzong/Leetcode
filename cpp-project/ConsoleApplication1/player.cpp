#include "player.h"
#include "hand.h"
#include "card.h"

// 简单玩家实现
class SimplePlayer : public Player {
public:
    int bet(unsigned int bankroll, unsigned int minimum) override {
        // 简单玩家总是下最小赌注
        return minimum;
    }

    bool draw(Card dealer, const Hand& player) override {
        auto value = player.handValue();
        if (value.soft) { // 如果手牌是软点数
            if (value.count <= 17) return true;
            if (value.count == 18) return !(dealer.spot == TWO || dealer.spot == SEVEN || dealer.spot == EIGHT);
            return false;
        }
        else { // 硬点数
            if (value.count <= 11) return true;
            if (value.count == 12) return !(dealer.spot >= FOUR && dealer.spot <= SIX);
            if (value.count >= 13 && value.count <= 16) return !(dealer.spot >= TWO && dealer.spot <= SIX);
            return false;
        }
    }

    void expose(Card c) override {
        // 简单玩家不做任何操作
    }

    void shuffled() override {
        // 牌堆洗牌后不做任何操作
    }
};

// 计数玩家实现
class CountingPlayer : public SimplePlayer {
private:
    int count = 0;

public:
    int bet(unsigned int bankroll, unsigned int minimum) override {
        if (count >= 2 && bankroll >= 2 * minimum) {
            return 2 * minimum; // 当计数较高时加倍赌注
        }
        return minimum;
    }

    void expose(Card c) override {
        // 根据卡片调整计数
        if (c.spot >= TEN) count--;
        if (c.spot >= TWO && c.spot <= SIX) count++;
    }

    void shuffled() override {
        // 洗牌时重置计数
        count = 0;
    }
};

// 全局玩家实例
SimplePlayer simplePlayer;
CountingPlayer countingPlayer;

// 访问函数
extern Player* get_Simple() {
    return &simplePlayer;
}

extern Player* get_Counting() {
    return &countingPlayer;
}
