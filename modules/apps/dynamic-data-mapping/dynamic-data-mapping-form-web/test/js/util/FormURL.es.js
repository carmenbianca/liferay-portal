/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import FormURL from '../../../src/main/resources/META-INF/resources/admin/js/util/FormURL.es';

const formInstanceId = 1;

describe('FormURL', () => {
	it('gets a blank url', () => {
		const published = false;
		const requireAuthentication = false;

		const formURL = new FormURL(
			formInstanceId,
			published,
			requireAuthentication
		);

		expect(formURL.create()).toBe('');
	});

	it('gets a valid restricted url', () => {
		const published = true;
		const requireAuthentication = true;

		const formURL = new FormURL(
			formInstanceId,
			published,
			requireAuthentication
		);

		expect(formURL.create()).toBe(
			Liferay.DDM.FormSettings.restrictedFormURL + formInstanceId
		);
	});

	it('gets a valid shared url', () => {
		const published = true;
		const requireAuthentication = false;

		const formURL = new FormURL(
			formInstanceId,
			published,
			requireAuthentication
		);

		expect(formURL.create()).toBe(
			Liferay.DDM.FormSettings.sharedFormURL + formInstanceId
		);
	});
});
