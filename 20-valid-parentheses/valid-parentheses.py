class Solution:
    def isValid(self, s: str) -> bool:
        st = []
        mp = {')' : '(', '}' : '{',']' : '['}

        for ch in s:
            if ch in mp.values():
                st.append(ch)
            else:
                if not st or st.pop() != mp[ch]:
                    return False
        return not st