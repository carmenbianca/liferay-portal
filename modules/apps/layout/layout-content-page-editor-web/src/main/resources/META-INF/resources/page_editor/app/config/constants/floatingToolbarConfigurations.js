/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {CollectionConfigurationPanel} from '../../../app/components/floating-toolbar/CollectionConfigurationPanel';
import {ContainerConfigurationPanel} from '../../../app/components/floating-toolbar/ContainerConfigurationPanel';
import {FragmentConfigurationPanel} from '../../../app/components/floating-toolbar/FragmentConfigurationPanel';
import {ImagePropertiesPanel} from '../../../app/components/floating-toolbar/ImagePropertiesPanel';
import LinkPanel from '../../../app/components/floating-toolbar/LinkPanel';
import {MappingPanel} from '../../../app/components/floating-toolbar/MappingPanel';
import {RowConfigurationPanel} from '../../../app/components/floating-toolbar/RowConfigurationPanel';
import {EDITABLE_FLOATING_TOOLBAR_BUTTONS} from './editableFloatingToolbarButtons';
import {LAYOUT_DATA_FLOATING_TOOLBAR_BUTTONS} from './layoutDataFloatingToolbarButtons';

const {
	collectionConfiguration,
	containerConfiguration,
	fragmentConfiguration,
	rowConfiguration,
} = LAYOUT_DATA_FLOATING_TOOLBAR_BUTTONS;

const {imageProperties, link, map} = EDITABLE_FLOATING_TOOLBAR_BUTTONS;

export const FLOATING_TOOLBAR_CONFIGURATIONS = {
	[collectionConfiguration.panelId]: CollectionConfigurationPanel,
	[containerConfiguration.panelId]: ContainerConfigurationPanel,
	[fragmentConfiguration.panelId]: FragmentConfigurationPanel,
	[imageProperties.panelId]: ImagePropertiesPanel,
	[link.panelId]: LinkPanel,
	[map.panelId]: MappingPanel,
	[rowConfiguration.panelId]: RowConfigurationPanel,
};
