/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ADD_MAPPED_INFO_ITEM} from './types';

/**
 * @param {object} options
 * @param {string} options.className
 * @param {string} options.classNameId
 * @param {string} options.classPK
 * @param {string} options.title
 * @return {object}
 */
export default function addMappedInfoItem({
	className,
	classNameId,
	classPK,
	title,
}) {
	return {
		className,
		classNameId,
		classPK,
		title,
		type: ADD_MAPPED_INFO_ITEM,
	};
}
