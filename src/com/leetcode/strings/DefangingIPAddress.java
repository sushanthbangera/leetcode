package com.leetcode.strings;

/*
 * 1108. Defanging an IP Address
 * https://leetcode.com/problems/defanging-an-ip-address/
 */
public class DefangingIPAddress {

	/*
	 * Time: O(n)
	 * Space: O(n)
	 */
	public String defangIPaddr(String address) {
		if (address == null || address.length() == 0)
			return address;

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < address.length(); i++) {
			if (address.charAt(i) == '.') {
				result.append("[.]");
			} else {
				result.append(address.charAt(i));
			}
		}
		return result.toString();
	}
}
