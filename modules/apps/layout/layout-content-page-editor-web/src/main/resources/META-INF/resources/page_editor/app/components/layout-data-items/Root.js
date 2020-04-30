/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import classNames from 'classnames';
import React from 'react';

import {
	LayoutDataPropTypes,
	getLayoutDataItemPropTypes,
} from '../../../prop-types/index';
import TopperEmpty from '../TopperEmpty';

const Root = React.forwardRef(({children, item, layoutData}, ref) => {
	return (
		<TopperEmpty item={item} layoutData={layoutData}>
			<div className={classNames('page-editor__root')} ref={ref}>
				{React.Children.count(children) ? (
					children
				) : (
					<div
						className={classNames(
							'page-editor__no-fragments-message'
						)}
					>
						<div className="page-editor__no-fragments-message__title">
							{Liferay.Language.get('place-fragments-here')}
						</div>
					</div>
				)}
			</div>
		</TopperEmpty>
	);
});

Root.displayName = 'Root';

Root.propTypes = {
	item: getLayoutDataItemPropTypes().isRequired,
	layoutData: LayoutDataPropTypes.isRequired,
};

export default Root;
