package com.robert.arch.ood.digcoin;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ���裺A һ��robotÿ������ڵ�8��coin��B 50��coin���Ի���һ��robot��
 * �ʣ�����5��robot��50��coin��10������ӵ�ж���coin��
 * 
 */
public class CoinDiggerControl {

	private List<CoinDiggerPerson> diggerPersons = new ArrayList<CoinDiggerPerson>();

	class CoinDiggerPerson {
		private static final int COINS_NUM_4_A_TOOL = 50;
		private static final int TOOL_PRODUCTS_COINS_NUM_PER_DAY = 40;

		private int toolNum;
		private int coinNum;

		public CoinDiggerPerson(int toolNum, int coinNum) {
			this.toolNum = toolNum;
			this.coinNum = coinNum;
		}

		public void buyToolByCoins() {
			if (coinNum >= COINS_NUM_4_A_TOOL) {
				int newToolNum = coinNum / COINS_NUM_4_A_TOOL;

				this.toolNum += newToolNum;

				this.coinNum = coinNum % COINS_NUM_4_A_TOOL;
			}
		}

		public void digCoinByToolPerDay() {
			this.coinNum += this.toolNum * TOOL_PRODUCTS_COINS_NUM_PER_DAY;
		}

		public int getTotalEquivalentCoins() {
			return this.coinNum + this.toolNum * COINS_NUM_4_A_TOOL;
		}
	}

	public CoinDiggerPerson newCoinDiggerPerson(int tools, int coins) {
		CoinDiggerPerson cdp = new CoinDiggerPerson(tools, coins);
		this.diggerPersons.add(cdp);

		return cdp;
	}

	public int digCoins(int days) {
		for (int i = 0; i < days; i++) {
			for (int j = 0; j < this.diggerPersons.size(); j++) {
				diggerPersons.get(j).buyToolByCoins();
				diggerPersons.get(j).digCoinByToolPerDay();
			}
		}

		int coins = 0;
		for (int j = 0; j < this.diggerPersons.size(); j++) {
			coins += diggerPersons.get(j).getTotalEquivalentCoins();
		}

		return coins;

	}

	public static void main(String[] args) {
		int days = 20;

		CoinDiggerControl cdm = new CoinDiggerControl();
		cdm.newCoinDiggerPerson(3, 50);
		int coins = cdm.digCoins(days);

		System.out.println(days + " days: " + coins + " coins.");
	}
}
