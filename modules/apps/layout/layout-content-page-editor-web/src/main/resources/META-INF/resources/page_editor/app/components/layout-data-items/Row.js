/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import classNames from 'classnames';
import PropTypes from 'prop-types';
import React, {useMemo} from 'react';

import {
	LayoutDataPropTypes,
	getLayoutDataItemPropTypes,
} from '../../../prop-types/index';
import {LAYOUT_DATA_ITEM_DEFAULT_CONFIGURATIONS} from '../../config/constants/layoutDataItemDefaultConfigurations';
import {LAYOUT_DATA_ITEM_TYPES} from '../../config/constants/layoutDataItemTypes';
import {useSelector} from '../../store/index';

const Row = React.forwardRef(({children, className, item, layoutData}, ref) => {
	const rowContent = (
		<div
			className={classNames(className, 'row', {
				empty: !item.children.some(
					childId => layoutData.items[childId].children.length
				),
				'no-gutters': !(typeof item.config.gutters === 'boolean'
					? item.config.gutters
					: LAYOUT_DATA_ITEM_DEFAULT_CONFIGURATIONS[item.type]),
			})}
			ref={ref}
		>
			{children}
		</div>
	);

	const masterLayoutData = useSelector(state => state.masterLayoutData);

	const masterParent = useMemo(() => {
		const dropZone =
			masterLayoutData &&
			masterLayoutData.items[masterLayoutData.rootItems.dropZone];

		return dropZone ? getItemParent(dropZone, masterLayoutData) : undefined;
	}, [masterLayoutData]);

	const shouldAddContainer = useSelector(
		state => !getItemParent(item, state.layoutData) && !masterParent
	);

	return shouldAddContainer ? (
		<div className="container-fluid p-0">{rowContent}</div>
	) : (
		rowContent
	);
});

Row.propTypes = {
	item: getLayoutDataItemPropTypes({
		config: PropTypes.shape({gutters: PropTypes.bool}),
	}).isRequired,
	layoutData: LayoutDataPropTypes.isRequired,
};

function getItemParent(item, itemLayoutData) {
	const parent = itemLayoutData.items[item.parentId];

	return parent && parent.type === LAYOUT_DATA_ITEM_TYPES.root
		? getItemParent(parent, itemLayoutData)
		: parent;
}

export default Row;
