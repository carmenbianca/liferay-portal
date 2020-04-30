/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {PagesVisitor} from 'dynamic-data-mapping-form-renderer';
import {useContext} from 'react';

import FormViewContext from './FormViewContext.es';
import {deleteDefinitionField} from './actions.es';

export default ({dataLayoutBuilder}) => {
	const [, dispatch] = useContext(FormViewContext);

	return fieldName => {
		const {pages} = dataLayoutBuilder.getStore();
		const visitor = new PagesVisitor(pages);

		if (visitor.containsField(fieldName, true)) {
			dataLayoutBuilder.dispatch('fieldDeleted', {fieldName});
		}
		else {
			dispatch(deleteDefinitionField(fieldName));
		}
	};
};
