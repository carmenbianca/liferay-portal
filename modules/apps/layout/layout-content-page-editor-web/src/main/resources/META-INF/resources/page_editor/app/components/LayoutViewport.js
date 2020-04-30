/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import classNames from 'classnames';
import PropTypes from 'prop-types';
import React, {useEffect, useRef, useState} from 'react';

import debounceRAF from '../../core/debounceRAF';
import {config} from '../config/index';
import {useSelector} from '../store/index';
import {useSelectItem} from './Controls';
import Layout from './Layout';
import MasterLayout from './MasterLayout';

export default function LayoutViewport({
	mainItemId,
	useMasterLayout,
	withinMasterPage = false,
}) {
	const handleRef = useRef();
	const [element, setElement] = useState(null);
	const [layoutWidth, setLayoutWidth] = useState();
	const [resizing, setResizing] = useState(false);
	const selectItem = useSelectItem();
	const selectedViewportSize = useSelector(
		state => state.selectedViewportSize
	);
	const sidebarOpen = useSelector(
		state => state.sidebar.panelId && state.sidebar.open
	);

	useEffect(() => {
		const handleViewport = handleRef.current;

		let initialWidth = 0;
		let initialX = 0;

		setLayoutWidth(undefined);

		const onDrag = debounceRAF(event => {
			const {maxWidth, minWidth} = config.availableViewportSizes[
				selectedViewportSize
			];

			setLayoutWidth(
				Math.min(
					Math.max(
						initialWidth + (event.clientX - initialX) * 2,
						minWidth
					),
					maxWidth + 1
				)
			);
		});

		const stopDrag = () => {
			setResizing(false);

			document.removeEventListener('mousemove', onDrag, true);
			document.removeEventListener('mouseup', stopDrag);
		};

		const initDrag = event => {
			if (element) {
				setResizing(true);
				selectItem(null);

				event.preventDefault();

				initialX = event.clientX;

				initialWidth =
					element.getBoundingClientRect().width -
					(parseInt(getComputedStyle(element).paddingRight, 10) || 0);

				setLayoutWidth(initialWidth);

				document.addEventListener('mousemove', onDrag, true);
				document.addEventListener('mouseup', stopDrag);
			}
		};

		if (handleViewport) {
			handleViewport.addEventListener('mousedown', initDrag, true);
		}

		return () => {
			if (handleViewport) {
				handleViewport.removeEventListener('mousedown', initDrag, true);
			}
		};
	}, [element, selectItem, selectedViewportSize]);

	return (
		<div
			className={classNames(
				'page-editor__layout-viewport',
				`page-editor__layout-viewport--size-${selectedViewportSize}`,
				{
					'page-editor__layout-viewport__resizing': resizing,
					'page-editor__layout-viewport--with-sidebar': !withinMasterPage,
					'page-editor__layout-viewport--with-sidebar-open':
						sidebarOpen && !withinMasterPage,
				}
			)}
		>
			{resizing && (
				<div className="page-editor__layout-viewport__label-width">
					<span>{layoutWidth}px</span>
				</div>
			)}

			<div
				className="page-editor__layout-viewport__resizer"
				ref={setElement}
				style={{width: layoutWidth}}
			>
				{useMasterLayout ? (
					<MasterLayout />
				) : (
					<Layout mainItemId={mainItemId} />
				)}
			</div>

			{selectedViewportSize !== 'desktop' && (
				<div
					className="page-editor__layout-viewport__handle"
					ref={handleRef}
				></div>
			)}
		</div>
	);
}

Layout.propTypes = {
	mainItemId: PropTypes.string.isRequired,
	useMasterLayout: PropTypes.object,
	withinMasterPage: PropTypes.bool,
};
