/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import classNames from 'classnames';
import PropTypes from 'prop-types';
import React, {useEffect, useState} from 'react';

import {
	BackgroundImagePropTypes,
	getLayoutDataItemPropTypes,
} from '../../../prop-types/index';
import {LAYOUT_DATA_ITEM_DEFAULT_CONFIGURATIONS} from '../../config/constants/layoutDataItemDefaultConfigurations';
import {LAYOUT_DATA_ITEM_TYPES} from '../../config/constants/layoutDataItemTypes';
import InfoItemService from '../../services/InfoItemService';
import {useDispatch} from '../../store/index';

const Container = React.forwardRef(({children, className, data, item}, ref) => {
	const {
		backgroundColorCssClass,
		backgroundImage,
		paddingBottom,
		paddingHorizontal,
		paddingTop,
		type,
	} = {
		...LAYOUT_DATA_ITEM_DEFAULT_CONFIGURATIONS[
			LAYOUT_DATA_ITEM_TYPES.container
		],
		...item.config,
	};

	const dispatch = useDispatch();

	const [backgroundImageValue, setBackgroundImageValue] = useState('');

	useEffect(() => {
		if (typeof backgroundImage.url === 'string') {
			setBackgroundImageValue(backgroundImage.url);
		}
		else if (backgroundImage.fieldId) {
			InfoItemService.getAssetFieldValue({
				classNameId: backgroundImage.classNameId,
				classPK: backgroundImage.classPK,
				fieldId: backgroundImage.fieldId,
				onNetworkStatus: dispatch,
			}).then(response => {
				const {fieldValue} = response;

				if (fieldValue && fieldValue.url !== backgroundImageValue) {
					setBackgroundImageValue(fieldValue.url);
				}
			});
		}
		else {
			setBackgroundImageValue('');
		}
	}, [backgroundImage, backgroundImageValue, dispatch, item]);

	return (
		<div
			{...data}
			className={classNames(
				className,
				`pb-${paddingBottom} pt-${paddingTop}`,
				{
					[`bg-${backgroundColorCssClass}`]: !!backgroundColorCssClass,
					[`px-${paddingHorizontal}`]: paddingHorizontal !== 3,
				}
			)}
			ref={ref}
			style={
				backgroundImageValue
					? {
							backgroundImage: `url(${backgroundImageValue})`,
							backgroundPosition: '50% 50%',
							backgroundRepeat: 'no-repeat',
							backgroundSize: 'cover',
					  }
					: {}
			}
		>
			<div
				className={classNames({
					container: type === 'fixed',
					'container-fluid': type === 'fluid',
				})}
			>
				{children}
			</div>
		</div>
	);
});

Container.propTypes = {
	item: getLayoutDataItemPropTypes({
		config: PropTypes.shape({
			backgroundColorCssClass: PropTypes.string,
			backgroundImage: BackgroundImagePropTypes,
			paddingBottom: PropTypes.number,
			paddingHorizontal: PropTypes.number,
			paddingTop: PropTypes.number,
			type: PropTypes.oneOf(['fluid', 'fixed']),
		}),
	}).isRequired,
};

export default Container;
