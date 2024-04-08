#include <stdexcept> // �����׳��쳣
#include <algorithm> // ����std::shuffle
#include <random>    // ����std::default_random_engine
#include <chrono>    // ���ڻ��һ������ʱ�������
#include "deck.h"
#include "card.h"
// ���캯��
Deck::Deck() {
    reset();
}

// �����ƶ�Ϊ�¿����״̬
void Deck::reset() {
    int cardIndex = 0;
    for (int suit = SPADES; suit <= DIAMONDS; ++suit) {
        for (int spot = TWO; spot <= ACE; ++spot) {
            deck[cardIndex].suit = static_cast<Suit>(suit);
            deck[cardIndex].spot = static_cast<Spot>(spot);
            ++cardIndex;
        }
    }
    next = 0; // ������һ��Ҫ������Ϊ�ƶѵĵ�һ����
}

// ϴ�Ʒ���
void Deck::shuffle(int n) {
    if (n < 0 || n > 52) throw std::invalid_argument("n must be between 0 and 52 inclusive.");

    // �Ƚ��ƶѵ�˳��ԭ���ϴ�ϴ�ƻ����ú��״̬
    reset();

    // ���ɻ���ʱ�������
    unsigned seed = std::chrono::system_clock::now().time_since_epoch().count();
    std::shuffle(deck, deck + DeckSize, std::default_random_engine(seed));

    // ����next����Ϊϴ�ƺ���һ��Ҫ���������ƶ��еĵ�һ����
    next = 0;
}

// ���Ʒ���
Card Deck::deal() {
    if (next >= DeckSize) throw std::runtime_error("No cards left in the deck.");
    return deck[next++];
}

// �������ϴ�����/ϴ��������δ�������Ƶ�����
int Deck::cardsLeft() {
    return DeckSize - next;
}
