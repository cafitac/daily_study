from django.urls import path

from member.views import get_users

urlpatterns = [
    path('', get_users),
]
