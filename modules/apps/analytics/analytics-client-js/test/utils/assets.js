/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {getNumberOfWords} from '../../src/utils/assets';

describe('getNumberOfWords()', () => {
	let document;

	beforeEach(() => {
		document = global.document;
	});

	it('returns the number of words', () => {
		const content = {
			description:
				'Build portals, intranets, websites and connected experiences on the most flexible platform around.',
			title: 'Digital Experience Software Tailored to Your Needs',
		};

		const markup = `<header class="header">
							<h2>${content.title}</h2>
							<p>${content.description}</p>
						</header>`;

		const element = document.createElement('div');

		setInnerHTML(element, markup);

		const numberOfWords = getNumberOfWords(element);

		expect(numberOfWords).toBe(20);
	});

	it('returns 0 if the number of words is empty', () => {
		const element = document.createElement('div');

		element.innerText = '';

		const numberOfWords = getNumberOfWords(element);

		expect(numberOfWords).toBe(0);
	});
});
