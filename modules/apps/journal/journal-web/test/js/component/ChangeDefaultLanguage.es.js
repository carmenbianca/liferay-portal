/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import '@testing-library/jest-dom/extend-expect';
import {
	cleanup,
	fireEvent,
	render,
	waitForElement,
} from '@testing-library/react';
import React from 'react';

import ChangeDefaultLanguage from '../../../src/main/resources/META-INF/resources/js/ChangeDefaultLanguage.es';

const defaultStrings = {
	ca_ES: 'Catalan (ES)',
	en_US: 'English (US)',
	es_ES: 'Spanish (ES)',
};

const defaultLanguages = [
	{icon: 'en-US', label: 'en_US'},
	{icon: 'es-ES', label: 'es_ES'},
	{icon: 'ca-ES', label: 'ca_ES'},
];

function _renderChangeDefaultLanguageComponent({
	defaultLanguage = 'en_US',
	languages = defaultLanguages,
	strings = defaultStrings,
} = {}) {
	return render(
		<ChangeDefaultLanguage
			defaultLanguage={defaultLanguage}
			languages={languages}
			strings={strings}
		/>,
		{
			baseElement: document.body,
		}
	);
}

describe('ChangeDefaultLanguage', () => {
	afterEach(() => {
		cleanup();
		jest.clearAllMocks();
	});

	it('render', () => {
		const {getByText} = _renderChangeDefaultLanguageComponent();

		expect(getByText('change'));
	});

	it('render the default language', () => {
		const {getByText} = _renderChangeDefaultLanguageComponent({
			defaultLanguage: 'es_ES',
		});

		expect(getByText('Spanish (ES)'));
	});

	it('change default language', async () => {
		const {getByText, getByTitle} = _renderChangeDefaultLanguageComponent();

		fireEvent.click(getByTitle('es_ES'));

		await waitForElement(() => getByText('Spanish (ES)'));

		expect(getByText('Spanish (ES)'));
	});

	it('to fire default locale changed event', () => {
		const {getByTitle} = _renderChangeDefaultLanguageComponent();

		const button = getByTitle('es_ES');

		fireEvent.click(button);

		expect(Liferay.fire).toHaveBeenCalled();

		expect(Liferay.fire.mock.calls[0][0]).toBe(
			'inputLocalized:defaultLocaleChanged'
		);

		expect(Liferay.fire.mock.calls[0][1].item.dataset.value).toBe('es_ES');
	});
});
