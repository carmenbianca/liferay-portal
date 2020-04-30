/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import dom from 'metal-dom';

import {getField, isFieldSet, isFieldSetChild} from './fieldSupport.es';

export const disableFieldSetDragSources = (element, pages) => {
	const dragSources = element.querySelectorAll('.ddm-drag');

	for (let i = 0; i < dragSources.length; i++) {
		const source = dragSources[i];

		const {fieldName} = source.parentElement.dataset;

		if (isFieldSetChild(pages, fieldName)) {
			source.setAttribute('data-drag-disabled', true);
		}
	}
};

export const disableFieldSetDropTargets = (element, pages) => {
	const dropTargets = element.querySelectorAll('.ddm-target');

	for (let i = 0; i < dropTargets.length; i++) {
		const target = dropTargets[i];

		const parentFieldNode = dom.closest(target, '.ddm-field-container');

		if (parentFieldNode) {
			const {fieldName} = parentFieldNode.dataset;

			const parentField = getField(pages, fieldName);

			if (
				(parentField && isFieldSet(parentField)) ||
				isFieldSetChild(pages, fieldName)
			) {
				target.setAttribute('data-drop-disabled', true);
			}
		}
	}
};
