/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ItemSelectorDialog} from 'frontend-js-web';

import {previewSeoFireChange} from './PreviewSeoEvents.es';

export default function({namespace, uploadOpenGraphImageURL}) {
	const openGraphImageButton = document.getElementById(
		`${namespace}openGraphImageButton`
	);

	const itemSelectorDialog = new ItemSelectorDialog({
		eventName: `${namespace}openGraphImageSelectedItem`,
		singleSelect: true,
		title: Liferay.Language.get('open-graph-image'),
		url: uploadOpenGraphImageURL,
	});

	const openGraphImageFileEntryId = document.getElementById(
		`${namespace}openGraphImageFileEntryId`
	);

	const openGraphImageTitle = document.getElementById(
		`${namespace}openGraphImageTitle`
	);

	const openGraphImageAltField = document.getElementById(
		`${namespace}openGraphImageAlt`
	);
	const openGraphImageAltFieldDefaultLocale = document.getElementById(
		`${namespace}openGraphImageAlt_${Liferay.ThemeDisplay.getLanguageId()}`
	);
	const openGraphImageAltLabel = document.querySelector(
		`[for="${namespace}openGraphImageAlt"`
	);

	itemSelectorDialog.on('selectedItemChange', event => {
		const selectedItem = event.selectedItem;

		if (selectedItem) {
			const itemValue = JSON.parse(selectedItem.value);

			openGraphImageFileEntryId.value = itemValue.fileEntryId;
			openGraphImageTitle.value = itemValue.title;

			Liferay.Util.toggleDisabled(openGraphImageAltField, false);
			Liferay.Util.toggleDisabled(
				openGraphImageAltFieldDefaultLocale,
				false
			);
			Liferay.Util.toggleDisabled(openGraphImageAltLabel, false);

			previewSeoFireChange(namespace, {
				type: 'imgUrl',
				value: itemValue.url,
			});
		}
	});

	openGraphImageButton.addEventListener('click', () => {
		itemSelectorDialog.open();
	});

	const openGraphClearImageButton = document.getElementById(
		`${namespace}openGraphClearImageButton`
	);

	openGraphClearImageButton.addEventListener('click', () => {
		openGraphImageFileEntryId.value = '';
		openGraphImageTitle.value = '';

		Liferay.Util.toggleDisabled(openGraphImageAltField, true);
		Liferay.Util.toggleDisabled(openGraphImageAltFieldDefaultLocale, true);
		Liferay.Util.toggleDisabled(openGraphImageAltLabel, true);

		previewSeoFireChange(namespace, {
			type: 'imgUrl',
			value: '',
		});
	});

	const openGraphTitleEnabledCheck = document.getElementById(
		`${namespace}openGraphTitleEnabled`
	);
	const openGraphTitleField = document.getElementById(
		`${namespace}openGraphTitle`
	);
	const openGraphTitleFieldDefaultLocale = document.getElementById(
		`${namespace}openGraphTitle_${Liferay.ThemeDisplay.getLanguageId()}`
	);

	openGraphTitleEnabledCheck.addEventListener('click', event => {
		const disabled = !event.target.checked;

		Liferay.Util.toggleDisabled(openGraphTitleField, disabled);
		Liferay.Util.toggleDisabled(openGraphTitleFieldDefaultLocale, disabled);

		previewSeoFireChange(namespace, {
			disabled,
			type: 'title',
			value: openGraphTitleField.value,
		});
	});

	const openGraphDescriptionEnabledCheck = document.getElementById(
		`${namespace}openGraphDescriptionEnabled`
	);
	const openGraphDescriptionField = document.getElementById(
		`${namespace}openGraphDescription`
	);
	const openGraphDescriptionFieldDefaultLocale = document.getElementById(
		`${namespace}openGraphDescription_${Liferay.ThemeDisplay.getLanguageId()}`
	);

	openGraphDescriptionEnabledCheck.addEventListener('click', event => {
		const disabled = !event.target.checked;

		Liferay.Util.toggleDisabled(openGraphDescriptionField, disabled);
		Liferay.Util.toggleDisabled(
			openGraphDescriptionFieldDefaultLocale,
			disabled
		);

		previewSeoFireChange(namespace, {
			disabled,
			type: 'description',
			value: openGraphDescriptionField.value,
		});
	});
}
