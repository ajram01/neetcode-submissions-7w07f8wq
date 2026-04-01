class Solution:
    def isValid(self, s: str) -> bool:

        if len(s) < 2:
            return False
        
        stack = []
        mapping = { '}': '{', ']': '[', ')': '('}
        for char in s:

            if char in mapping.values():
                stack.append(char)
            elif char in mapping:
                if not stack or stack[-1] != mapping[char]:
                    return False
                stack.pop()
        if stack:
            return False
        return True