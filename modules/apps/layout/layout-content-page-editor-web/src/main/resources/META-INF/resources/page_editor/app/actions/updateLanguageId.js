/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {UPDATE_LANGUAGE_ID} from './types';

/**
 * @param {string} languageId
 * @return {object}
 */
export default function updateLanguageId({languageId}) {
	return {
		languageId,
		type: UPDATE_LANGUAGE_ID,
	};
}
