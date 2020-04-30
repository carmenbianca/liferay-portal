/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {evaluate} from '../../util/evaluation.es';
import {PagesVisitor} from '../../util/visitors.es';

export default (evaluatorContext, properties, updateState) => {
	const {fieldInstance, value} = properties;
	const {evaluable, fieldName} = fieldInstance;
	const {editingLanguageId, pages} = evaluatorContext;
	const pageVisitor = new PagesVisitor(pages);

	const editedPages = pageVisitor.mapFields(
		field => {
			if (field.name === fieldInstance.name) {
				return {
					...field,
					localizedValue: {
						...field.localizedValue,
						[editingLanguageId]: value,
					},
					value,
				};
			}

			return field;
		},
		false,
		true
	);

	updateState(editedPages);

	let promise = Promise.resolve(editedPages);

	if (evaluable) {
		promise = evaluate(fieldName, {
			...evaluatorContext,
			pages: editedPages,
		});
	}

	return promise;
};
