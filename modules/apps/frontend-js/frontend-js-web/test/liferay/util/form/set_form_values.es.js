/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

'use strict';

import dom from 'metal-dom';

import getFormElement from '../../../../src/main/resources/META-INF/resources/liferay/util/form/get_form_element.es';
import setFormValues from '../../../../src/main/resources/META-INF/resources/liferay/util/form/set_form_values.es';

describe('Liferay.Util.setFormValues', () => {
	it('sets the given values of form elements', () => {
		const fragment = dom.buildFragment(`
					<form data-fm-namespace="_com_liferay_test_portlet_" id="fm">
						<input name="_com_liferay_test_portlet_foo" type="text" value="abc">
						<input name="_com_liferay_test_portlet_bar" type="text" value="123">
					</form>
				`);

		const form = fragment.firstElementChild;

		setFormValues(form, {
			bar: '456',
			foo: 'def',
		});

		const barElement = getFormElement(form, 'bar');
		const fooElement = getFormElement(form, 'foo');

		expect(barElement.value).toEqual('456');
		expect(fooElement.value).toEqual('def');
	});
});
