/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React, {useContext} from 'react';

import {CollectionItemContext} from '../CollectionItemContext';
import TopperEmpty from '../TopperEmpty';

const CollectionItemWithControls = React.forwardRef(
	({children, item, layoutData}, ref) => {
		const {collectionItem} = useContext(CollectionItemContext);

		return (
			<div className="page-editor__collection__block">
				{React.Children.count(children) === 0 ? (
					<TopperEmpty item={item} layoutData={layoutData}>
						<div className="page-editor__collection-item" ref={ref}>
							<p className="page-editor__collection-item__title">
								{collectionItem.title}
							</p>
						</div>
					</TopperEmpty>
				) : (
					children
				)}
			</div>
		);
	}
);

export default CollectionItemWithControls;
