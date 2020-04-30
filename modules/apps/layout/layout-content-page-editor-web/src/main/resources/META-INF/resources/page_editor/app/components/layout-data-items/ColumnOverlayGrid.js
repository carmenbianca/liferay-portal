/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import classNames from 'classnames';
import PropTypes from 'prop-types';
import React from 'react';
import {createPortal} from 'react-dom';

import {FragmentsEditorShim} from './FragmentsEditorShim';

export default function ColumnOverlayGrid({
	columnSpacing,
	highlightedColumn = null,
	rowRect,
}) {
	return createPortal(
		<div
			className="page-editor__column-overlay-grid position-fixed"
			style={{
				height: `${rowRect.height}px`,
				left: `${rowRect.left}px`,
				top: `${rowRect.top}px`,
				width: `${rowRect.width}px`,
			}}
		>
			<FragmentsEditorShim />

			<div
				className={classNames('container-fluid h-100 py-0', {
					'px-0': !columnSpacing,
				})}
			>
				<div
					className={classNames('h-100 row', {
						'no-gutters': !columnSpacing,
					})}
				>
					{[...Array(12).keys()].map(column => (
						<div
							className={classNames(
								'col page-editor__column-overlay-grid__column',
								{
									'page-editor__column-overlay-grid__column--highlighted':
										column === highlightedColumn,
								}
							)}
							key={`col-overlay-grid-column-${column}`}
						>
							<div className="h-100 page-editor__column-overlay-grid__column-content" />
						</div>
					))}
				</div>
			</div>
		</div>,
		document.body
	);
}

ColumnOverlayGrid.propTypes = {
	columnSpacing: PropTypes.bool.isRequired,
	highlightedColumn: PropTypes.number,
	rowRect: PropTypes.shape({
		height: PropTypes.number.isRequired,
		left: PropTypes.number.isRequired,
		top: PropTypes.number.isRequired,
		width: PropTypes.number.isRequired,
	}).isRequired,
};
