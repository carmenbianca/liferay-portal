/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayIcon from '@clayui/icon';
import classNames from 'classnames';
import PropTypes from 'prop-types';
import React, {useEffect, useState} from 'react';

export default function Collapse(props) {
	const [open, setOpen] = useState(props.open);
	const collapseIcon = open ? 'angle-down' : 'angle-right';
	const collapseIconClassName = open ? 'open' : 'closed';

	useEffect(() => {
		setOpen(props.open);
	}, [props.open]);

	const handleClick = () => {
		setOpen(!open);
	};

	return (
		<div className="page-editor__collapse panel-group panel-group-flush">
			<button
				aria-expanded={open}
				className={classNames('collapse-icon', 'sheet-subtitle', {
					collapsed: !open,
				})}
				onClick={handleClick}
			>
				{props.label}
				<span className={`collapse-icon-${collapseIconClassName}`}>
					<ClayIcon key={collapseIcon} symbol={collapseIcon} />
				</span>
			</button>
			{open && props.children}
		</div>
	);
}

Collapse.propTypes = {
	children: PropTypes.node.isRequired,
	open: PropTypes.bool,
};
