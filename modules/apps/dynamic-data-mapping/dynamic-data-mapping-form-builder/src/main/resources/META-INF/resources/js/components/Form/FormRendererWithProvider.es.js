/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {PagesVisitor} from 'dynamic-data-mapping-form-builder';

import FormRenderer from './FormRenderer.es';

class FormRendererWithProvider extends FormRenderer {
	_handleFieldEdited(properties) {
		const pageVisitor = new PagesVisitor(this.pages);

		const pages = pageVisitor.mapFields(field => {
			if (field.fieldName === properties.fieldInstance.fieldName) {
				return {
					...field,
					value: properties.value,
				};
			}
		});

		this.pages = pages;
	}

	created() {
		this.on('fieldEdited', this._handleFieldEdited);
	}
}

export default FormRendererWithProvider;
