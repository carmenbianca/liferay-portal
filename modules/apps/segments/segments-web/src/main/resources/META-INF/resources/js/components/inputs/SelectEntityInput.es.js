/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import {ItemSelectorDialog} from 'frontend-js-web';
import propTypes from 'prop-types';
import React from 'react';

class SelectEntityInput extends React.Component {
	static propTypes = {
		disabled: propTypes.bool,
		displayValue: propTypes.oneOfType([propTypes.string, propTypes.number]),
		onChange: propTypes.func.isRequired,
		selectEntity: propTypes.shape({
			id: propTypes.string,
			multiple: propTypes.bool,
			title: propTypes.string,
			uri: propTypes.string,
		}),
		value: propTypes.oneOfType([propTypes.string, propTypes.number]),
	};

	/**
	 * Opens a modal for selecting entities. Uses different methods for
	 * selecting multiple entities versus single because of the way the event
	 * and data is submitted.
	 */
	_handleSelectEntity = () => {
		const {
			onChange,
			selectEntity: {id, multiple, title, uri},
		} = this.props;

		if (multiple) {
			const itemSelectorDialog = new ItemSelectorDialog({
				buttonAddLabel: Liferay.Language.get('select'),
				eventName: id,
				title,
				url: uri,
			});

			itemSelectorDialog.open();

			itemSelectorDialog.on('selectedItemChange', event => {
				const selectedItems = event.selectedItem;

				if (selectedItems) {
					const selectedValues = selectedItems.map(item => ({
						displayValue: item.name,
						value: item.id,
					}));

					onChange(selectedValues);
				}
			});
		}
		else {
			Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						destroyOnHide: true,
						modal: true,
					},
					id,
					title,
					uri,
				},
				event => {
					onChange({
						displayValue: event.entityname,
						value: event.entityid,
					});
				}
			);
		}
	};

	render() {
		const {disabled, displayValue, value} = this.props;

		return (
			<div className="criterion-input input-group select-entity-input">
				<div className="input-group-item input-group-prepend">
					<input
						data-testid="entity-select-input"
						disabled={disabled}
						type="hidden"
						value={value}
					/>

					<input
						className="form-control"
						disabled={disabled}
						readOnly
						value={displayValue}
					/>
				</div>

				<span className="input-group-append input-group-item input-group-item-shrink">
					<ClayButton
						disabled={disabled}
						displayType="secondary"
						onClick={this._handleSelectEntity}
					>
						{Liferay.Language.get('select')}
					</ClayButton>
				</span>
			</div>
		);
	}
}

export default SelectEntityInput;
