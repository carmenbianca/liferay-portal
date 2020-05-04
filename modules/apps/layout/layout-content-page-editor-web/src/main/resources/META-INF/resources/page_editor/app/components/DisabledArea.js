/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayPopover from '@clayui/popover';
import {useEventListener} from 'frontend-js-react-web';
import {match} from 'metal-dom';
import {Align} from 'metal-position';
import React, {useEffect, useLayoutEffect, useRef, useState} from 'react';
import {createPortal} from 'react-dom';

import {useSelector} from '../store/index';
import {useSelectItem} from './Controls';

const DEFAULT_DISABLED_AREA_CLASS = 'page-editor__disabled-area';
const DEFAULT_ORIGIN = 'layout-content';
const DEFAULT_WHITELIST = [
	DEFAULT_ORIGIN,
	DEFAULT_DISABLED_AREA_CLASS,
	'control-menu',
	'lfr-add-panel',
	'lfr-product-menu-panel',
];
const POPOVER_POSITIONS = {
	[Align.Bottom]: 'bottom',
	[Align.BottomLeft]: 'bottom',
	[Align.BottomRight]: 'bottom',
	[Align.Left]: 'left',
	[Align.Right]: 'right',
	[Align.Top]: 'top',
	[Align.TopLeft]: 'top',
	[Align.TopRight]: 'top',
};
const STATIC_POSITIONS = ['', 'static', 'relative'];

const DisabledArea = () => {
	const popoverRef = useRef(null);
	const [currentElementClicked, setCurrentElementClicked] = useState(null);
	const [show, setShow] = useState(false);
	const [position, setPosition] = useState('bottom');
	const sidebarOpen = useSelector(state => state.sidebar.open);
	const selectItem = useSelectItem();

	const isDisabled = element => {
		const {height} = element.getBoundingClientRect();
		const {position} = window.getComputedStyle(element);

		const hasAbsolutePosition = STATIC_POSITIONS.indexOf(position) === -1;
		const hasZeroHeight = height === 0;

		return (
			element.tagName !== 'SCRIPT' &&
			!hasZeroHeight &&
			!hasAbsolutePosition &&
			!DEFAULT_WHITELIST.some(
				selector =>
					match(element, `.${selector}`) ||
					element.querySelector(`.${selector}`)
			)
		);
	};

	useEffect(() => {
		const element = document.querySelector(
			`.${DEFAULT_DISABLED_AREA_CLASS}`
		);

		if (element) {
			if (sidebarOpen) {
				element.classList.add('collapsed');
			}
			else {
				element.classList.remove('collapsed');
			}
		}
	}, [sidebarOpen]);

	useEventListener(
		'scroll',
		() => {
			if (show) {
				setCurrentElementClicked(null);
				setShow(false);
			}
		},
		true,
		document
	);

	useEventListener(
		'click',
		event => {
			if (
				Array.from(event.target.classList).includes(
					DEFAULT_DISABLED_AREA_CLASS
				)
			) {
				setCurrentElementClicked(event.target);
				selectItem(null);
				setShow(true);
			}
			else if (show) {
				setCurrentElementClicked(null);
				setShow(false);
			}
		},
		true,
		document.body
	);

	useLayoutEffect(() => {
		if (popoverRef.current && currentElementClicked && show) {
			const suggestedAlign = Align.suggestAlignBestRegion(
				popoverRef.current,
				currentElementClicked,
				Align.TopCenter
			);

			const bestPosition =
				suggestedAlign.position !== Align.TopCenter
					? Align.BottomCenter
					: Align.TopCenter;

			Align.align(
				popoverRef.current,
				currentElementClicked,
				bestPosition,
				false
			);

			setPosition(POPOVER_POSITIONS[bestPosition]);
		}
	}, [show, popoverRef, currentElementClicked]);

	useLayoutEffect(() => {
		let element = document.querySelector(`.${DEFAULT_ORIGIN}`);

		while (element.parentElement && element !== document.body) {
			Array.from(element.parentElement.children).forEach(
				child =>
					isDisabled(child) &&
					child.classList.add(DEFAULT_DISABLED_AREA_CLASS)
			);

			element = element.parentElement;
		}

		return () => {
			const elements = document.querySelectorAll(
				`.${DEFAULT_DISABLED_AREA_CLASS}`
			);

			elements.forEach(element =>
				element.classList.remove(DEFAULT_DISABLED_AREA_CLASS)
			);
		};
	}, []);

	return (
		show &&
		createPortal(
			<ClayPopover alignPosition={position} ref={popoverRef} show>
				{Liferay.Language.get(
					'this-area-is-defined-by-the-theme.-to-change-theme-settings-go-to-the-look-and-feel-configuration-in-the-sidebar'
				)}
			</ClayPopover>,
			document.body
		)
	);
};

export default DisabledArea;
