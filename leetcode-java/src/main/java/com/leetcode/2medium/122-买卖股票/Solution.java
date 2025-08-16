class Solution {
    /**
     * 计算可以获得的最大利润。
     * @param prices 股票每天的价格数组
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        // 如果数组为空或只有一个元素，无法进行交易，利润为0。
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // 初始化总利润为0
        int totalProfit = 0;

        // 我们从第二天开始遍历（索引为1），比较当天的价格和前一天的价格。
        // 或者从索引0遍历到倒数第二个，比较 prices[i] 和 prices[i+1]，效果一样。
        // 这里采用后者，更容易理解。
        for (int i = 0; i < prices.length - 1; i++) {
            // 贪心策略：如果明天的价格比今天高，我们就在今天“买入”，明天“卖出”。
            if (prices[i + 1] > prices[i]) {
                // 将这段上涨的利润累加到总利润中
                totalProfit += prices[i + 1] - prices[i];
            }
        }

        // 循环结束后，totalProfit 就累加了所有上涨区间的利润。
        return totalProfit;
    }
}