/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

AUI.add(
	'liferay-address',
	() => {
		if (!Liferay.Address) {
			Liferay.Address = {
				getCountries(callback) {
					Liferay.Service(
						'/country/get-countries',
						{
							active: true,
						},
						callback
					);
				},

				getRegions(callback, selectKey) {
					Liferay.Service(
						'/region/get-regions',
						{
							active: true,
							countryId: Number(selectKey),
						},
						callback
					);
				},
			};
		}
	},
	'',
	{
		requires: [],
	}
);
