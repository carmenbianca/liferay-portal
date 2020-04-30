/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {cancelDebounce, debounce} from 'frontend-js-web';
import {useRef} from 'react';

import lang from './lang.es';

export function getCKEditorConfig() {
	const config = {
		codeSnippet_theme: 'monokai_sublime',
		extraPlugins: 'codesnippet',
		height: 216,
	};
	config.toolbarGroups = [
		{groups: ['basicstyles', 'cleanup'], name: 'basicstyles'},
		{
			groups: ['list', 'indent', 'blocks', 'align', 'bidi', 'paragraph'],
			name: 'paragraph',
		},
		{groups: ['codesnippet'], name: 'insert'},
		{groups: ['links'], name: 'links'},
		{groups: ['clipboard', 'undo'], name: 'clipboard'},
		{groups: ['mode', 'document', 'doctools'], name: 'document'},
		{
			groups: ['find', 'selection', 'spellchecker', 'editing'],
			name: 'editing',
		},
	];
	config.removeButtons =
		'About,Anchor,BGColor,BidiLtr,BidiRtl,Button,Checkbox,Copy,CopyFormatting,CreateDiv,Cut,Find,Flash,Font,FontSize,Form,Format,HiddenField,HorizontalRule,Iframe,Image,ImageButton,JustifyBlock,JustifyCenter,JustifyLeft,JustifyRight,Language,Maximize,NewPage,PageBreak,Paste,PasteFromWord,PasteText,Preview,Print,Radio,RemoveFormat,Replace,Save,Select,SelectAll,ShowBlocks,Smiley,SpecialChar,Styles,Subscript,Superscript,Table,Templates,TextColor,TextField,Textarea';

	return config;
}

export function onBeforeLoadCKEditor(CKEditor) {
	if (CKEditor) {
		CKEditor.disableAutoInline = true;
	}
}

export function dateToInternationalHuman(
	ISOString,
	localeKey = navigator.language
) {
	const date = new Date(ISOString);

	const options = {
		day: 'numeric',
		hour: '2-digit',
		minute: '2-digit',
		month: 'short',
	};

	const intl = new Intl.DateTimeFormat(localeKey, options);

	return intl.format(date);
}

export function dateToBriefInternationalHuman(
	ISOString,
	localeKey = navigator.language
) {
	const date = new Date(ISOString);

	const intl = new Intl.DateTimeFormat(localeKey, {
		day: '2-digit',
		month: '2-digit',
		year: '2-digit',
	});

	return intl.format(date);
}

export function timeDifference(previous, current = new Date()) {
	const msPerMinute = 60 * 1000;
	const msPerHour = msPerMinute * 60;
	const msPerDay = msPerHour * 24;
	const msPerMonth = msPerDay * 30;
	const msPerYear = msPerDay * 365;

	const elapsed = current - new Date(previous);

	if (elapsed < msPerMinute) {
		return lang.sub(Liferay.Language.get('asked-x-seconds-ago-by'), [
			Math.round(elapsed / 1000),
		]);
	}
	else if (elapsed < msPerHour) {
		return lang.sub(Liferay.Language.get('asked-x-minutes-ago-by'), [
			Math.round(elapsed / msPerMinute),
		]);
	}
	else if (elapsed < msPerDay) {
		return lang.sub(Liferay.Language.get('asked-x-hours-ago-by'), [
			Math.round(elapsed / msPerHour),
		]);
	}
	else if (elapsed < msPerMonth) {
		return lang.sub(Liferay.Language.get('asked-x-days-ago-by'), [
			Math.round(elapsed / msPerDay),
		]);
	}
	else if (elapsed < msPerYear) {
		return lang.sub(Liferay.Language.get('asked-x-months-ago-by'), [
			Math.round(elapsed / msPerMonth),
		]);
	}
	else {
		return lang.sub(Liferay.Language.get('asked-x-years-ago-by'), [
			Math.round(elapsed / msPerYear),
		]);
	}
}

export function useDebounceCallback(callback, milliseconds) {
	const callbackRef = useRef(debounce(callback, milliseconds));

	return [callbackRef.current, () => cancelDebounce(callbackRef.current)];
}

export function normalizeRating(aggregateRating) {
	return (
		aggregateRating &&
		aggregateRating.ratingCount * normalize(aggregateRating.ratingAverage)
	);
}

export function normalize(ratingValue) {
	return ratingValue * 2 - 1;
}

export function stringToSlug(text) {
	const whiteSpaces = /\s+/g;

	return text.replace(whiteSpaces, '-').toLowerCase();
}

export function slugToText(slug) {
	const hyphens = /-+/g;

	return slug.replace(hyphens, ' ').toLowerCase();
}

export function historyPushWithSlug(push) {
	return url => push(stringToSlug(url));
}
