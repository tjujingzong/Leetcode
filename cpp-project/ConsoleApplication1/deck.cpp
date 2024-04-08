#include <stdexcept> // 用于抛出异常
#include <algorithm> // 用于std::shuffle
#include <random>    // 用于std::default_random_engine
#include <chrono>    // 用于获得一个基于时间的种子
#include "deck.h"
#include "card.h"
// 构造函数
Deck::Deck() {
    reset();
}

// 重置牌堆为新开封的状态
void Deck::reset() {
    int cardIndex = 0;
    for (int suit = SPADES; suit <= DIAMONDS; ++suit) {
        for (int spot = TWO; spot <= ACE; ++spot) {
            deck[cardIndex].suit = static_cast<Suit>(suit);
            deck[cardIndex].spot = static_cast<Spot>(spot);
            ++cardIndex;
        }
    }
    next = 0; // 设置下一张要发的牌为牌堆的第一张牌
}

// 洗牌方法
void Deck::shuffle(int n) {
    if (n < 0 || n > 52) throw std::invalid_argument("n must be between 0 and 52 inclusive.");

    // 先将牌堆的顺序复原到上次洗牌或重置后的状态
    reset();

    // 生成基于时间的种子
    unsigned seed = std::chrono::system_clock::now().time_since_epoch().count();
    std::shuffle(deck, deck + DeckSize, std::default_random_engine(seed));

    // 调整next，因为洗牌后下一张要发的牌是牌堆中的第一张牌
    next = 0;
}

// 发牌方法
Card Deck::deal() {
    if (next >= DeckSize) throw std::runtime_error("No cards left in the deck.");
    return deck[next++];
}

// 返回自上次重置/洗牌以来尚未发出的牌的数量
int Deck::cardsLeft() {
    return DeckSize - next;
}
