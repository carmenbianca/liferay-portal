/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import {
	LayoutDataPropTypes,
	getLayoutDataItemPropTypes,
} from '../../../prop-types/index';
import {LAYOUT_DATA_FLOATING_TOOLBAR_BUTTONS} from '../../config/constants/layoutDataFloatingToolbarButtons';
import selectSegmentsExperienceId from '../../selectors/selectSegmentsExperienceId';
import {useDispatch, useSelector} from '../../store/index';
import duplicateItem from '../../thunks/duplicateItem';
import {useSelectItem} from '../Controls';
import Topper from '../Topper';
import FloatingToolbar from '../floating-toolbar/FloatingToolbar';
import Collection from './Collection';

const CollectionWithControls = React.forwardRef(
	({children, item, layoutData}, ref) => {
		const dispatch = useDispatch();
		const selectItem = useSelectItem();
		const segmentsExperienceId = useSelector(selectSegmentsExperienceId);

		const buttons = [];

		buttons.push(
			LAYOUT_DATA_FLOATING_TOOLBAR_BUTTONS.duplicateItem,
			LAYOUT_DATA_FLOATING_TOOLBAR_BUTTONS.collectionConfiguration
		);

		const handleButtonClick = id => {
			if (id === LAYOUT_DATA_FLOATING_TOOLBAR_BUTTONS.duplicateItem.id) {
				dispatch(
					duplicateItem({
						itemId: item.itemId,
						selectItem,
						store: {segmentsExperienceId},
					})
				);
			}
		};

		return (
			<Topper item={item} itemRef={ref} layoutData={layoutData}>
				<>
					<Collection item={item} ref={ref}>
						{children}
					</Collection>

					<FloatingToolbar
						buttons={buttons}
						item={item}
						itemRef={ref}
						onButtonClick={handleButtonClick}
					/>
				</>
			</Topper>
		);
	}
);

CollectionWithControls.propTypes = {
	item: getLayoutDataItemPropTypes().isRequired,
	layoutData: LayoutDataPropTypes.isRequired,
};

export default CollectionWithControls;
