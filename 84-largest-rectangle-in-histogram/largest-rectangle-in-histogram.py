class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        n = len(heights)
        pse = [-1]*n
        st=[]
        for i in range(n):
            while st!=[] and heights[st[-1]]>=heights[i]:
                st.pop()
            if st!=[]:
                pse[i]=st[-1]
            st.append(i)
        st = []
        nse = [n]*n
        for i in range(n-1,-1,-1):
            while st!=[] and heights[st[-1]]>=heights[i]:
                st.pop()
            if st!=[]:
                nse[i]=st[-1]
            st.append(i)
        maxi = float('-inf')
        for i in range(n):
            area = heights[i]*(nse[i]-pse[i]-1)
            maxi = max(maxi,area)
        return maxi