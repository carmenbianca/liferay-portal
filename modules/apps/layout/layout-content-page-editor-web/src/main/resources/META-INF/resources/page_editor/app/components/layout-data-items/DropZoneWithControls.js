/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import {
	LayoutDataPropTypes,
	getLayoutDataItemPropTypes,
} from '../../../prop-types/index';
import ManageAllowedFragmentButton from '../ManageAllowedFragmentButton';
import Topper from '../Topper';

const DropZoneWithControls = React.forwardRef(({item, layoutData}, ref) => {
	return (
		<Topper active item={item} itemRef={ref} layoutData={layoutData}>
			<div className="page-editor__drop-zone" ref={ref}>
				<p>{Liferay.Language.get('drop-zone')}</p>

				<p>
					{Liferay.Language.get(
						'fragments-and-widgets-for-pages-based-on-this-master-will-be-placed-here'
					)}
				</p>

				<ManageAllowedFragmentButton item={item} />
			</div>
		</Topper>
	);
});

DropZoneWithControls.propTypes = {
	item: getLayoutDataItemPropTypes().isRequired,
	layoutData: LayoutDataPropTypes.isRequired,
};

export default DropZoneWithControls;
