#include "player.h"
#include "hand.h"
#include "card.h"

// �����ʵ��
class SimplePlayer : public Player {
public:
    int bet(unsigned int bankroll, unsigned int minimum) override {
        // �������������С��ע
        return minimum;
    }

    bool draw(Card dealer, const Hand& player) override {
        auto value = player.handValue();
        if (value.soft) { // ��������������
            if (value.count <= 17) return true;
            if (value.count == 18) return !(dealer.spot == TWO || dealer.spot == SEVEN || dealer.spot == EIGHT);
            return false;
        }
        else { // Ӳ����
            if (value.count <= 11) return true;
            if (value.count == 12) return !(dealer.spot >= FOUR && dealer.spot <= SIX);
            if (value.count >= 13 && value.count <= 16) return !(dealer.spot >= TWO && dealer.spot <= SIX);
            return false;
        }
    }

    void expose(Card c) override {
        // ����Ҳ����κβ���
    }

    void shuffled() override {
        // �ƶ�ϴ�ƺ����κβ���
    }
};

// �������ʵ��
class CountingPlayer : public SimplePlayer {
private:
    int count = 0;

public:
    int bet(unsigned int bankroll, unsigned int minimum) override {
        if (count >= 2 && bankroll >= 2 * minimum) {
            return 2 * minimum; // �������ϸ�ʱ�ӱ���ע
        }
        return minimum;
    }

    void expose(Card c) override {
        // ���ݿ�Ƭ��������
        if (c.spot >= TEN) count--;
        if (c.spot >= TWO && c.spot <= SIX) count++;
    }

    void shuffled() override {
        // ϴ��ʱ���ü���
        count = 0;
    }
};

// ȫ�����ʵ��
SimplePlayer simplePlayer;
CountingPlayer countingPlayer;

// ���ʺ���
extern Player* get_Simple() {
    return &simplePlayer;
}

extern Player* get_Counting() {
    return &countingPlayer;
}
