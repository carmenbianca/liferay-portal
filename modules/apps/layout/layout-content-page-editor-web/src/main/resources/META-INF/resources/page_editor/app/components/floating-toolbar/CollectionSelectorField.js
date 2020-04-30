/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayForm from '@clayui/form';
import PropTypes from 'prop-types';
import React from 'react';

import CollectionSelector from '../../../common/components/CollectionSelector';
import {ConfigurationFieldPropTypes} from '../../../prop-types/index';

export const CollectionSelectorField = ({field, onValueSelect, value}) => {
	const {typeOptions = {}} = field;

	return (
		<ClayForm.Group small>
			<CollectionSelector
				collectionTitle={value.title}
				itemSelectorURL={typeOptions.infoListSelectorURL}
				label={field.label}
				onCollectionSelect={collection => {
					onValueSelect(field.name, collection);
				}}
			></CollectionSelector>
		</ClayForm.Group>
	);
};

CollectionSelectorField.propTypes = {
	field: PropTypes.shape(ConfigurationFieldPropTypes).isRequired,
	onValueSelect: PropTypes.func.isRequired,
	value: PropTypes.oneOfType([PropTypes.string, PropTypes.object]),
};
