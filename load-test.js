import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
	stages: [
		{ duration: '1m', target: 200 }, // Плавный разгон до 20 пользователей
		{ duration: '3m', target: 1000 }, // Резкое увеличение нагрузки для срабатывания HPA
		{ duration: '1m', target: 0 },  // Снижение нагрузки
	],
	thresholds: {
		http_req_duration: ['p(95)<500'], // 95% запросов должны быть быстрее 500мс
	},
};

export default function () {
	// host.docker.internal перенаправит запрос на ваш localhost, где слушает Ingress
	const url = 'http://snowflake.dev.local/next-id';
	// const params = {
	// 	headers: { 'Host': 'id-generator-service' }, // Если Ingress настроен на конкретный хост
	// };
	http.get(url);
	sleep(0.1);
}
