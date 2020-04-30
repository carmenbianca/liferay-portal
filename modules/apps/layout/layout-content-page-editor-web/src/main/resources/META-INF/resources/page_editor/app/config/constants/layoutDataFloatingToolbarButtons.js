/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

/**
 * FloatingToolbar panels
 */
export const LAYOUT_DATA_FLOATING_TOOLBAR_BUTTONS = {
	collectionConfiguration: {
		icon: 'cog',
		id: 'collection_configuration',
		panelId: 'collection_configuration',
		title: Liferay.Language.get('collection-display-configuration'),
		type: 'panel',
	},

	containerConfiguration: {
		icon: 'cog',
		id: 'container_configuration',
		panelId: 'container_configuration',
		title: Liferay.Language.get('section-configuration'),
		type: 'panel',
	},

	duplicateItem: {
		icon: 'paste',
		id: 'duplicate_item',
		panelId: '',
		title: Liferay.Language.get('duplicate'),
		type: 'panel',
	},

	fragmentBackgroundImage: {
		icon: 'pencil',
		id: 'fragment_background_image',
		panelId: 'fragment_background_image',
		title: Liferay.Language.get('fragment-background-image'),
		type: 'panel',
	},

	fragmentConfiguration: {
		icon: 'cog',
		id: 'fragment_configuration',
		panelId: 'fragment_configuration',
		title: Liferay.Language.get('fragment-configuration'),
		type: 'panel',
	},

	rowConfiguration: {
		icon: 'cog',
		id: 'row_configuration',
		panelId: 'row_configuration',
		title: Liferay.Language.get('row-configuration'),
		type: 'panel',
	},

	saveFragmentComposition: {
		icon: 'download',
		id: 'save_fragment_composition',
		panelId: 'save_fragment_compositionn',
		title: Liferay.Language.get('save-as-fragment'),
		type: 'panel',
	},
};
