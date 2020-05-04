/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import FallbackProcessor from '../../../../src/main/resources/META-INF/resources/page_editor/app/processors/FallbackProcessor';

describe('FallbackProcessor', () => {
	describe('createEditor', () => {
		it('sets contenteditable attribute to the given element', () => {
			const element = document.createElement('div');

			FallbackProcessor.createEditor(element);
			expect(element.hasAttribute('contenteditable')).toBe(true);
		});
	});

	describe('destroyEditor', () => {
		it('removes contenteditable attribute from the given element', () => {
			const element = document.createElement('div');

			element.setAttribute('contenteditable', 'true');
			FallbackProcessor.destroyEditor(element);
			expect(element.hasAttribute('contenteditable')).toBe(false);
		});
	});

	describe('render', () => {
		it('injects the given string as innerHTML', () => {
			const element = document.createElement('div');

			FallbackProcessor.render(element, 'I am Juan Kastro');
			expect(element.innerHTML).toBe('I am Juan Kastro');
		});
	});
});
