/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.pql;

/**
 * @author Michael Hashimoto
 */
public class PQLModifierFactory {

	public static PQLModifier newPQLModifier(String modifier) throws Exception {
		PQLModifier.validateModifier(modifier);

		if (modifier.equals("NOT")) {
			return new PQLModifier(modifier) {

				public Object getPQLResult(Object pqlResultObject)
					throws Exception {

					String modifier = getModifier();

					if ((pqlResultObject == null) ||
						!(pqlResultObject instanceof Boolean)) {

						throw new Exception(
							"Modifier must be used with a boolean value: " +
								modifier);
					}

					Boolean pqlResultBoolean = (Boolean)pqlResultObject;

					return !pqlResultBoolean;
				}

			};
		}

		throw new Exception("Unsupported modifier: " + modifier);
	}

}