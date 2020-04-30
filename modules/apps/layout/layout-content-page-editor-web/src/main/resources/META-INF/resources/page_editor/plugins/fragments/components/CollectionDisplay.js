/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayIcon from '@clayui/icon';
import classNames from 'classnames';
import React from 'react';

import {useSelectItem} from '../../../app/components/Controls';
import {LAYOUT_DATA_ITEM_TYPES} from '../../../app/config/constants/layoutDataItemTypes';
import {useDispatch, useSelector} from '../../../app/store/index';
import addItem from '../../../app/thunks/addItem';
import {useItemDrag} from '../../../app/utils/useItemDrag';
import Collapse from '../../../common/components/Collapse';

const CollectionDisplayCard = () => {
	const dispatch = useDispatch();
	const store = useSelector(state => state);
	const selectItem = useSelectItem();

	const dragRef = useItemDrag({
		name: Liferay.Language.get('collection-display'),
		onDragEnd: (parentId, position) => {
			dispatch(
				addItem({
					itemType: LAYOUT_DATA_ITEM_TYPES.collection,
					parentItemId: parentId,
					position,
					selectItem,
					store,
				})
			);
		},
		type: LAYOUT_DATA_ITEM_TYPES.collection,
	});

	return (
		<div
			className={classNames(
				'page-editor__fragments__fragment-card',
				'card',
				'card-interactive',
				'card-interactive-secondary',
				'selector-button',
				'overflow-hidden'
			)}
			ref={dragRef}
		>
			<div className="page-editor__fragments__fragment-card-no-preview">
				<ClayIcon symbol="list" />
			</div>

			<div className="card-body">
				<div className="card-row">
					<div className="autofit-col autofit-col-expand autofit-row-center">
						<div className="card-title text-truncate">
							{Liferay.Language.get('collection-display')}
						</div>
					</div>
				</div>
			</div>
		</div>
	);
};

export default function CollectionDisplay() {
	return (
		<>
			<Collapse
				label={Liferay.Language.get('collection-display')}
				open={false}
			>
				<div className="d-flex flex-wrap justify-content-between">
					<CollectionDisplayCard />
				</div>
			</Collapse>
		</>
	);
}
