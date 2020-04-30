/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayForm, {ClayCheckbox, ClaySelectWithOption} from '@clayui/form';
import PropTypes from 'prop-types';
import React, {useState} from 'react';

import {getLayoutDataItemPropTypes} from '../../../prop-types/index';
import {LAYOUT_DATA_ITEM_DEFAULT_CONFIGURATIONS} from '../../config/constants/layoutDataItemDefaultConfigurations';
import {LAYOUT_DATA_ITEM_TYPES} from '../../config/constants/layoutDataItemTypes';
import selectSegmentsExperienceId from '../../selectors/selectSegmentsExperienceId';
import {useDispatch, useSelector} from '../../store/index';
import updateItemConfig from '../../thunks/updateItemConfig';
import updateRowColumns from '../../thunks/updateRowColumns';

const NUMBER_OF_COLUMNS_OPTIONS = ['1', '2', '3', '4', '5', '6'];

const ROW_CONFIGURATION_IDENTIFIERS = {
	gutters: 'gutters',
	numberOfColumns: 'numberOfColumns',
};

const ClayCheckboxWithState = ({onValueChange, ...otherProps}) => {
	const [value, setValue] = useState(false);

	return (
		<ClayCheckbox
			checked={value}
			onChange={({target: {checked}}) => {
				setValue(val => !val);
				onValueChange(checked);
			}}
			{...otherProps}
		/>
	);
};

export const RowConfigurationPanel = ({item}) => {
	const dispatch = useDispatch();
	const segmentsExperienceId = useSelector(selectSegmentsExperienceId);

	const rowConfig = {
		...LAYOUT_DATA_ITEM_DEFAULT_CONFIGURATIONS[LAYOUT_DATA_ITEM_TYPES.row],
		...item.config,
	};

	const handleConfigurationValueChanged = (identifier, value) => {
		if (identifier === ROW_CONFIGURATION_IDENTIFIERS.numberOfColumns) {
			const currentNumberOfColumns = rowConfig.numberOfColumns;
			const newNumberOfColumns = value;

			const columnsToBeModified = Math.abs(
				newNumberOfColumns - currentNumberOfColumns
			);

			if (columnsToBeModified === 0) {
				return;
			}

			if (item && item.itemId) {
				dispatch(
					updateRowColumns({
						itemId: item.itemId,
						numberOfColumns: newNumberOfColumns,
						segmentsExperienceId,
					})
				);
			}

			return;
		}

		dispatch(
			updateItemConfig({
				itemConfig: {
					[identifier]: value,
				},
				itemId: item.itemId,
				segmentsExperienceId,
			})
		);
	};

	return (
		<>
			<ClayForm.Group small>
				<label htmlFor="rowNumberOfColumns">
					{Liferay.Language.get('number-of-columns')}
				</label>
				<ClaySelectWithOption
					aria-label={Liferay.Language.get('number-of-columns')}
					id="rowNumberOfColumns"
					onChange={({target: {value}}) => {
						handleConfigurationValueChanged(
							ROW_CONFIGURATION_IDENTIFIERS.numberOfColumns,
							Number(value)
						);
					}}
					options={NUMBER_OF_COLUMNS_OPTIONS.map(value => ({
						label: value,
						value,
					}))}
					value={String(rowConfig.numberOfColumns)}
				/>
			</ClayForm.Group>
			{rowConfig.numberOfColumns > 1 && (
				<ClayForm.Group>
					<ClayCheckboxWithState
						aria-label={Liferay.Language.get('columns-gutter')}
						checked={rowConfig.gutters}
						label={Liferay.Language.get('columns-gutter')}
						onValueChange={value =>
							handleConfigurationValueChanged(
								ROW_CONFIGURATION_IDENTIFIERS.gutters,
								value
							)
						}
					/>
				</ClayForm.Group>
			)}
		</>
	);
};

RowConfigurationPanel.propTypes = {
	item: getLayoutDataItemPropTypes({
		config: PropTypes.shape({numberOfColumns: PropTypes.number}),
	}),
};
