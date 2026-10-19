from collections import deque


class ClassQueue:

    @staticmethod
    def print_non_repeating(s):
        q = deque()
        freq = [0] * 26

        for i in range(len(s)):
            ch = s[i]
            q.append(ch)
            freq[ord(ch) - ord('a')] += 1

            while q and freq[ord(q[0]) - ord('a')] > 1:
                q.popleft()
            
            if not q:
                print(-1, end=" ")
            else:
                print(q[0], end=" ")

    @staticmethod
    def interleave_2_halves(q):
        first_half = deque()
        size = len(q)

        for i in range(size // 2):
            first_half.append(q.popleft())
            
        while first_half:
            q.append(first_half.popleft())
            q.append(q.popleft())


if __name__ == "__main__":
    # Queue test for interleaving
    q = deque([1, 2, 3, 4, 5, 6, 7, 8])
    print(list(q))

    ClassQueue.interleave_2_halves(q)
    
    while q:
        print(q.popleft(), end=" ")
    print()

    # Non-repeating character stream test
    ClassQueue.print_non_repeating("aabccxb")
    print()

    # Deque test
    dq = deque()
    dq.appendleft(3)
    dq.appendleft(2)
    dq.appendleft(1)
    dq.append(4)

    while dq:
        print(dq.popleft(), end=" ")
    print()
