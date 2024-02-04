from django.urls import path

from member.views import get_users, run_task

urlpatterns = [
    path('', get_users),
    path('run/', run_task),
]
