class Solution:
    def smallestPalindrome(self, s: str, k: int) -> str:
        f = Counter(s)

        h = {}
        mid = ""

        for ch, cnt in f.items():
            h[ch] = cnt // 2
            if cnt % 2:
                mid = ch
        
        def count_permutations(cnt):
            total = sum(cnt.values())
            res = 1
            rem = total
            for x in cnt.values():
                if x:
                    res *= comb(rem, x)
                    rem -= x
                    if res >= k:
                        return res
            return res

        if count_permutations(h) < k:
            return ""

        left = []
        length = len(s) // 2

        for _ in range(length):
            for ch in map(chr, range(ord('a'), ord('z') + 1)):
                if h.get(ch, 0) == 0:
                    continue

                h[ch] -= 1
                ways = count_permutations(h)

                if ways >= k:
                    left.append(ch)
                    break

                k -= ways
                h[ch] += 1

        left = "".join(left)
        return left + mid + left[::-1]