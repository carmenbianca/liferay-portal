/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

export function disableEntryIcon(element) {
	element.parentElement.classList.add('disabled');

	element.setAttribute('data-href', element.getAttribute('href'));
	element.setAttribute('data-onclick', element.getAttribute('onclick'));

	element.removeAttribute('href');
	element.removeAttribute('onclick');
}

export function enableEntryIcon(element) {
	element.parentElement.classList.remove('disabled');

	element.setAttribute('href', element.getAttribute('data-href'));
	element.setAttribute('onclick', element.getAttribute('data-onclick'));

	element.removeAttribute('data-href');
	element.removeAttribute('data-onclick');
}
