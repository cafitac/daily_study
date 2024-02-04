from celery import shared_task
from celery.utils.log import get_task_logger

logger = get_task_logger(__name__)


@shared_task
def my_task(arg1, arg2):
    logger.info(f"[MY_TASK] Adding {arg1} + {arg2}")
    result = arg1 + arg2
    return result
