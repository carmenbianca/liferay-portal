/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {CheckboxField} from '../../components/floating-toolbar/CheckboxField';
import {CollectionSelectorField} from '../../components/floating-toolbar/CollectionSelectorField';
import {ColorPaletteField} from '../../components/floating-toolbar/ColorPaletteField';
import {ItemSelectorField} from '../../components/floating-toolbar/ItemSelectorField';
import {SelectField} from '../../components/floating-toolbar/SelectField';
import {TextField} from '../../components/floating-toolbar/TextField';

export const FRAGMENT_CONFIGURATION_FIELD_TYPES = {
	checkbox: CheckboxField,
	collectionSelector: CollectionSelectorField,
	colorPalette: ColorPaletteField,
	itemSelector: ItemSelectorField,
	select: SelectField,
	text: TextField,
};
