/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

/**
 * Prepares given element to show tooltip
 * @param {HTMLElement} element The portlet's namespace
 * @param {String} text Text to show in tooltip
 * @deprecated As of Athanasius (7.3.x), replaced by ClayTooltip
 */
export function showTooltip(element, text) {
	element.setAttribute('title', text);

	element.classList.add('lfr-portal-tooltip');
}
