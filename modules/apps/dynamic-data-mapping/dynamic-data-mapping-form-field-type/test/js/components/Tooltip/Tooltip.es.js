/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {dom as MetalTestUtil} from 'metal-dom';

import Tooltip from '../../../src/main/resources/META-INF/resources/components/Tooltip/Tooltip.es';

let component;
const spritemap = 'icons.svg';

describe('Field Tooltip', () => {
	beforeEach(() => {
		jest.useFakeTimers();
	});

	afterEach(() => {
		if (component) {
			component.dispose();
		}
	});

	it('renders the default markup', () => {
		component = new Tooltip({
			icon: 'question-circle-full',
			spritemap,
			text: 'This is a tooltip information about this component',
		});

		expect(component).toMatchSnapshot();
	});

	it('updates the tooltip visible state when the mouse is over the tooltip target', () => {
		component = new Tooltip({
			icon: 'question-circle-full',
			spritemap,
			text: 'This is a tooltip information about this component',
		});

		jest.runAllTimers();

		const {tooltipTarget} = component.refs;

		MetalTestUtil.triggerEvent(tooltipTarget, 'mouseover');

		expect(component.showContent).toBe(true);
		expect(component).toMatchSnapshot();
	});

	it('updates the tooltip visible state when the mouse leaved the tooltip target', () => {
		component = new Tooltip({
			icon: 'question-circle-full',
			spritemap,
			text: 'This is a tooltip information about this component',
		});

		component._handleTooltipHovered();
		component._handleTooltipLeaved();

		expect(component.showContent).toBe(false);
		expect(component).toMatchSnapshot();
	});

	it('updates the tooltip visible state when the mouse is over the tooltip target', () => {
		component = new Tooltip({
			icon: 'question-circle-full',
			spritemap,
			text: 'This is a tooltip information about this component',
		});

		jest.runAllTimers();

		component.refs.tooltipSource = {
			element: document.createElement('div'),
		};

		component._handleTooltipHovered();
		component._handleTooltipRendered();

		expect(component.showContent).toBe(true);
		expect(component).toMatchSnapshot();
	});
});
