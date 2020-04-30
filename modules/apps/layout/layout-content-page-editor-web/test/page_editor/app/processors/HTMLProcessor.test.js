/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import HTMLProcessor from '../../../../src/main/resources/META-INF/resources/page_editor/app/processors/HTMLProcessor';

describe('HTMLProcessor', () => {
	describe('render', () => {
		it('injects the given string as innerHTML', () => {
			const element = document.createElement('div');

			HTMLProcessor.render(element, 'Jordi Kappler');
			expect(element.innerHTML).toBe('Jordi Kappler');
		});
	});
});
