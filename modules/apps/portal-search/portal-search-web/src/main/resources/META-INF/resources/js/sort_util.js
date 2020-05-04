/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

AUI.add(
	'liferay-search-sort-util',
	() => {
		var SortUtil = {
			addURLParameter(key, value, parameterArray) {
				key = encodeURIComponent(key);
				value = encodeURIComponent(value);

				parameterArray[parameterArray.length] = [key, value].join('=');

				return parameterArray;
			},

			removeURLParameters(key, parameterArray) {
				key = encodeURIComponent(key);

				var newParameters = parameterArray.filter(item => {
					var itemSplit = item.split('=');

					if (itemSplit && itemSplit[0] === key) {
						return false;
					}

					return true;
				});

				return newParameters;
			},

			setURLParameters(key, values, parameterArray) {
				var newParameters = SortUtil.removeURLParameters(
					key,
					parameterArray
				);

				values.forEach(item => {
					newParameters = SortUtil.addURLParameter(
						key,
						item,
						newParameters
					);
				});

				return newParameters;
			},

			updateQueryString(key, selections, queryString) {
				var search = queryString;

				var hasQuestionMark = false;

				if (search[0] === '?') {
					hasQuestionMark = true;
				}

				if (hasQuestionMark) {
					search = search.substr(1);
				}

				var parameterArray = search.split('&').filter(item => {
					return item.trim() !== '';
				});

				var newParameters = SortUtil.setURLParameters(
					key,
					selections,
					parameterArray
				);

				search = newParameters.join('&');

				if (hasQuestionMark) {
					search = '?' + search;
				}

				return search;
			},
		};

		Liferay.namespace('Search').SortUtil = SortUtil;
	},
	'',
	{
		requires: [],
	}
);
