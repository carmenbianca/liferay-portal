/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {fireEvent, render} from '@testing-library/react';
import React from 'react';
import {act} from 'react-dom/test-utils';

import {Modal} from '../../../src/main/resources/META-INF/resources/liferay/modal/Modal';

describe('Modal', () => {
	beforeEach(() => {
		jest.useFakeTimers();
	});

	it('renders markup based on given configuration', () => {
		const {baseElement} = render(
			<Modal
				id="abcd"
				size="lg"
				title="My Modal"
				url="https://www.sample.url?p_p_id=com_liferay_MyPortlet"
			/>
		);

		act(() => {
			jest.runAllTimers();
		});

		expect(baseElement).toMatchSnapshot();
	});

	it('renders in full screen, if url is set', () => {
		const {baseElement} = render(<Modal url="https://www.sample.url" />);

		expect(baseElement.querySelector('.modal-full-screen')).toBeTruthy();
	});

	it('renders in given size, even if url is set', () => {
		const {baseElement} = render(
			<Modal size="lg" url="https://www.sample.url" />
		);

		expect(baseElement.querySelector('.modal-lg')).toBeTruthy();
	});

	it('closes modal on cancel type button click', () => {
		const onCloseCallback = jest.fn();

		render(
			<Modal
				buttons={[{id: 'myButton', type: 'cancel'}]}
				onClose={onCloseCallback}
			/>
		);

		act(() => {
			jest.runAllTimers();
		});

		fireEvent.click(document.getElementById('myButton'));

		expect(onCloseCallback).toBeCalled();
	});
});
